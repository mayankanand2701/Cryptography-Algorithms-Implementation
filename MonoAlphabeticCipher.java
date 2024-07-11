import java.util.HashSet;
import java.util.Scanner;
public class MonoAlphabeticCipher {
	static char[] arr1= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static char[] arr2=new char[26];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for Encryption");
		System.out.println("Enter 2 for Decryption");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:System.out.println("Enter the Plain text : ");
		       String str=sc.nextLine();
		       System.out.println("Enter the Key : ");
		       String key=sc.next();
		       encryption(str,key);
			   break;
		case 2:System.out.println("Enter the Cipher text : ");
		       String str1=sc.nextLine();
		       System.out.println("Enter the Key : ");
		       String key1=sc.next();
		       break;
		default:System.out.println("Wrong Choice Opted !");
		}
	}
	static void encryption(String str,String key)
	{
		HashSet<Character> set=new HashSet<Character>();
		str=str.toUpperCase();
		key=key.toUpperCase();
		int index=0;
		for(int i=0;i<key.length();i++)
		{
			char ch=key.charAt(i);
			if(Character.isLetter(ch))
			{
				arr2[index++]=ch;
				set.add(ch);
			}
			else continue;
		}
		for(int i=0;i<26;i++)
		{
			if(set.contains(arr1[i])) continue;
			else arr2[index++]=arr1[i];
		}
		for(char ch:arr1)System.out.print(ch+"  ");
		for(char ch:arr2)System.out.print(ch+"  ");
	}

}
