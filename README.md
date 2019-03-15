# kira

This project utilizes the shade plugin to make an executable jar..
Add your token to config.json and your path to Main.java..
Then to run navigate to project folder and run "mvn package" this will output a jar to your /target folder. To run enter "java -jar target/kira-1.0.jar"

The permissions system requires 2 tables currently. "permissions" with columns (id bigint, permissions int) and "commandLevel" with a column for each command you wish to check for permissions set to type int. These must be created manually for the time being. You can use the below queries if you want. 

create table permissions (id bigint, permissions int);
create table commandLevel (ping int, xkcd int, eightball int, setpermission int);
update commandLevel set "command" = {permission desired} where "command" is null;
update permissions set permissions = {desired permission} where id = {id in question}

Alternatively you can just use ".setpermission {id} {permission level}" within discord if you set your own permissions properly.
