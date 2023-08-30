import java.net.*;
class Solution {
  public String validIPAddress(String IP) {
    try {
      return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
    } catch(Exception e) {}
    return "Neither";
  }
}