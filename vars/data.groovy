#!usr/bin/env groovy

def vm()
{
   return [ 1 : ["virtual_machine_1", "5c832d8a-57a6-405f-a1be-7eb0b12d517d", "192.168.50.50"], 2 : ["virtual_machine_2", "Jenkins_2", "192.168.51.51"], 3 : ["virtual_machine_3", "VirtualMachine3", "192.168.52.52"]]
}

def project()
{
   return ["https://github.com/yashbhangdia/Spring-Boot-Application-1.git" : [1, 2, 3], "https://github.com/yashbhangdia/SpringBoot-Application-2.git" : [3], "https://github.com/yashbhangdia/Liquibase_Project.git" : [1]] 
}

def app()
{
   return ["https://github.com/yashbhangdia/Spring-Boot-Application-1.git" : "SpringBootApplication1", "https://github.com/yashbhangdia/SpringBoot-Application-2.git" : "SpringBootApplication2", "https://github.com/yashbhangdia/Liquibase_Project.git" : "Liquibase_Project"]
}

def services()
{
   return ["192.168.50.50":[8090, 8092], "192.168.51.51":[8090], "192.168.52.52":[8090, 8091]]
}
