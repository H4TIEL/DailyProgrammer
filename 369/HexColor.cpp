#include <iostream>
#include <sstream>
std::string decimalToHex(int decimal);
std::string hexcolor(int red, int green, int blue);
int main()
{
   std::cout<<hexcolor(255, 99, 71) << std::endl;
   std::cout<<hexcolor(0, 0, 205) << std::endl;
}

std::string decimalToHex(int decimal)
{
  std::stringstream ss;
  ss << std::hex << decimal;
  std::string hex(ss.str());  
  // handle preceding zeros
  if(hex.length() == 1) hex.append("0",0,1);
  return hex;
}
std::string hexcolor(int red, int green, int blue)
{
   std::string hexColor = "#";
   hexColor.append(decimalToHex(red));
   hexColor.append(decimalToHex(green));
   hexColor.append(decimalToHex(blue));
   return hexColor;
}
