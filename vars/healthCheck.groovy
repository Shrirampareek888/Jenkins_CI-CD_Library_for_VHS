#!/usr/bin/env groovy
import groovy.json.JsonSlurper
    
def call()
{
    def ips = []
    def vmData = data.vm()
    def ipdata = data.services()
    String s = ""
    for(int i=0;i<vmData.size();i++)
    {

        def ip = vmData[i+1][2]
        
        for(int j=0;j<ipdata[ip].size;j++)
        {
            def port = ipdata[ip][j];
            final String url = "http://"+"${ip}"+":"+"${port}"+"/actuator/health"
            try 
            {         
                def response = bat(script: "@curl -s $url", returnStdout: true)
                JsonSlurper slurper = new JsonSlurper()
                Map parsedJson = slurper.parseText(response)

                String val = parsedJson.status
                if(val!="UP")
                {
                    def temp = [:]
                    temp.ip = ip
                    temp.status = val
                    ips.add(temp)  
                }
                s += ip + " - " + port + " : " + val + "^\n\n"
            }
             catch (Exception e) 
            {
                def temp = [:]
                temp.ip = ip
                temp.status = "DOWN"
                ips.add(temp)
                s += ip + " - " + port + " : " + "DOWN" + "^\n\n"
            }
        }
    }
    bat "@echo ${s} > logfile.txt"
}

