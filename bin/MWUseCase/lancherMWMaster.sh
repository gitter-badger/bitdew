echo "java  xtremweb.role.mw.Master --oob $1 --workers $2 --host $3 --file $4  ";
java -cp build:conf:lib/commons-io-1.3.1.jar:lib/commons-fileupload-1.1.1.jar:lib/commons-codec-1.3.jar:lib/commons-logging-1.1.jar:lib/commons-httpclient-3.1-beta1.jar:lib/junit-4.1.jar:lib/dks.jar:lib/commons-net-1.3.0.jar:lib/commons-collections-3.1.jar:lib/commons-dbcp-1.2.1.jar:lib/commons-pool-1.2.jar:lib/jpox-dbcp-1.1.0-rc-1.jar:lib/jargs.jar:lib/mysql.jar:lib/hsqldb.jar:lib/bcel.jar:lib/jdo.jar:lib/jpox-1.1.0-rc-1.jar:lib/log4j.jar:lib/jetty-6.1.1.jar:lib/jetty-util-6.1.1.jar:lib/servlet-api-2.5-6.1.1.jar:build/xtremweb/core/obj/obj/obj.jdo:conf/dbcp.properties  -Djava.security.manager -Djava.security.policy=conf/java.policy -Dlog4j.configuration=file:conf/log4j.properties xtremweb.role.mw.Master --oob $1 --workers $2 --host $3  --file $4 ;







