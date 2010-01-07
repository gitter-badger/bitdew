package xtremweb.serv.dr;

/*
<Object name="Protocol">
<Attribute  name="uid" type="String" desc="Uniq Identifier"/>
<Attribute  name="name" type="String" desc="Name of the protocol"/>
<Attribute  name="server" type="String" desc="Server name"/>
<Attribute  name="port" type="int" desc="Port to contact"/>
<Attribute  name="login" type="String" desc="Login name (if necessary)"/>
<Attribute  name="password" type="String" desc="Password (if necessary)"/>
<Attribute  name="path" type="String" desc="Path (if necessary)"/>
</Object>
*/

import xtremweb.core.obj.dr.Protocol;

public class ProtocolUtil {

    public static String toString(Protocol proto) {
	String tmp =  "proto " + proto.getname() + " [" + proto.getuid() + "] = { ";
	if (proto.getserver() != null) tmp += "server" + proto.getserver() + ", " ;
	if (proto.getport() != 0) tmp += "port" + proto.getport() + ", ";
	if (proto.getlogin() != null) tmp += "port" + proto.getlogin() + ", ";
	if (proto.getpassword() != null) tmp += "port" + proto.getpassword() + ", ";
	if (proto.getpath() != null) tmp += "port" + proto.getpath() + ", ";

	return tmp + " }";
    }

}
