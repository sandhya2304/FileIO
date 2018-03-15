package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainClass
{
	//player information used after loading/during actual game play
	int playerHealth=100;
	int playerX=10,playerY=10;
	
	int curentLevel=2;
	
	
	//player infomation gathered from save file
	int[] saveInformation={playerHealth,playerX,playerY,curentLevel};
	
	//these are location
	int pHLoc=0;
	int pXLoc=1;
	int pYLoc=2;
	int cLLoc=3;
	
	
	public MainClass()
	{
		
		try
		{
			//Dynamic coding
			//readfile("C:\\Users\\dlc\\workspace1\\coding\\FileIO\\Test.txt");
			//writeFile("C:\\Users\\dlc\\workspace1\\coding\\FileIO\\Test.txt");
			
			readPlayer("C:\\Users\\dlc\\workspace1\\coding\\FileIO\\PlayerSave.txt");
			
			//savePlayer("C:\\Users\\dlc\\workspace1\\coding\\FileIO\\PlayerSave.txt");
			
			
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private void savePlayer(String filePath)
	{
		File outputfile;
		BufferedWriter bw;
		
		try
		{
			outputfile=new File(filePath);
			bw=new BufferedWriter(new FileWriter(outputfile));
			
			
			
			saveInformation[pHLoc] = playerHealth;
			saveInformation[pXLoc] =playerX;
			saveInformation[pYLoc] =playerY;
			saveInformation[cLLoc] =curentLevel;


			for(int i=0;i < saveInformation.length;i++)
			{
				bw.write(Integer.toString(saveInformation[i]) + "\n");
			}
			
			
			bw.close();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void readPlayer(String filePath)
	{
		
		File file;
		BufferedReader br;
		
		try
		{
			file=new File(filePath);
			br=new BufferedReader(new FileReader(file));
			
			for(int i=0;i<saveInformation.length;i++)
			{
				saveInformation[i]= Integer.parseInt(br.readLine()); 
			}
			
			
			playerHealth=saveInformation[pHLoc];
			playerX=saveInformation[pXLoc];
			playerY=saveInformation[pYLoc];
			curentLevel=saveInformation[cLLoc];
	
			br.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	
	private void readfile(String filePath)
	{
		
		File file;
		BufferedReader br;
		
		try
		{
			file=new File(filePath);
			br=new BufferedReader(new FileReader(file));
			
			String filetxt=br.readLine();
			System.out.println(filetxt);
			br.close();
		}catch(Exception e){e.printStackTrace();}
	}
	
	private void writeFile(String filePath)
	{
		File outputfile;
		BufferedWriter bw;
		
		try
		{
			outputfile=new File(filePath);
			bw=new BufferedWriter(new FileWriter(outputfile));
			bw.write("this is here im");
			bw.close();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) 
	{
		
		new MainClass();

	}

}
