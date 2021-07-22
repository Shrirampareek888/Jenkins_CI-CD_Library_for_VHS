#!usr/bin/env groovy
def call(url,appname)
{
  try 
        {
          bat label: '', script: 'oc new-app java~'+"${url}"+' --allow-missing-images=true --name='+"${appname}"
        }
        catch (err) 
        {
          echo "something failed"
        }
        
        bat label: '', script: 'oc start-build '+"${appname}"
        
        try
        {
            bat label: '', script: 'oc expose svc '+"${appname}"
        }
        catch(err)
        {
            echo "something failed"
        }
}
