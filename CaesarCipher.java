import java.util.HashMap;
import java.util.Scanner;
public class CaesarCipher
{
	static HashMap<Character,Integer> emap = new HashMap<>();
	static HashMap<Integer,Character> dmap = new HashMap<>();
	public static void main(String[] args) 
	{
		char ch='A';
		for(int i=0;i<26;i++)emap.put(ch++,i);
		ch='A';
		for(int i=0;i<26;i++)dmap.put(i,ch++);
		
		Scanner sc=new Scanner(System.in);
		
		
		// For Encryption 
		System.out.println("Encryption : ");
		System.out.println("Enter the Plain text  : ");
		String str=sc.next();
		str=str.toUpperCase();
		System.out.println("Enter the key  : ");
		int key=sc.nextInt();
		System.out.println("-------------------------------------------------");
		System.out.println("The Cipher Text after Encryption is : "+encryption(str,key));
		System.out.println("-------------------------------------------------");
	
		// For Decryption
		System.out.println("Decryption : ");
		System.out.println("Enter the Cipher text  : ");
		String str1=sc.next();
		str1=str1.toUpperCase();
		System.out.println("Enter the key  : ");
		int key1=sc.nextInt();
		System.out.println("-------------------------------------------------");
		System.out.println("The Plain text after Decryption is : "+decryption(str1,key1));
		System.out.println("-------------------------------------------------");
		
	}
	static String encryption(String str,int key)
	{
		String emessage="";
		for(char ch:str.toCharArray())
		{
			int index=emap.getOrDefault(ch, -1);
			 if (index !=-1)
			 {
				 int location=(index+key)%26;
				 emessage+=dmap.get(location);
			 }
			 else emessage+=ch;
		}
		return emessage;
	}
	static String decryption(String str,int key)
	{
		String dmessage="";
		for(char ch:str.toCharArray())
		{
			int index=emap.getOrDefault(ch, -1);
			if(index!=-1)
			{
				int location=(index-key+26)%26;
				dmessage+=dmap.get(location);
			}
			else dmessage+=ch;
		}
		return dmessage;
	}
}

