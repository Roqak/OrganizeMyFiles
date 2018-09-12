import java.util.*;
import java.io.*;
// import java.nio.file.Files;
import java.nio.file.*;
public class OrganizeMyFiles{
	public static void moveThem(String fileFrom, String fileTo){
			try{
				//THE PATH LIBRARY TO MOVE OUR FILES
		Path filePath = Files.move(Paths.get(fileFrom),Paths.get(fileTo)); 
  
        if(filePath != null) 
        { 
            System.out.println("File moved successfully"); 
        } 
        else
        { 
            System.out.println("Failed to move the file"); 
        } 
		}catch(IOException ioException){
			System.out.println(ioException);
		}
	}
	public static void main(String args[])
	{
		String fileType = "unknown";
		//YOUR DOWNLOAD DIRECTORY
		File downloads = new File("/home/scripter/Downloads");
		File[] listoffiles = downloads.listFiles();
		for(int i =0; i<listoffiles.length; i++){
			// System.out.println(listoffiles[i].toPath());
			// System.out.println("File: " + listoffiles[i].getName());
			try{
				//GET FILE EXTENSION
			fileType = Files.probeContentType(listoffiles[i].toPath());
				System.out.println(fileType);
				switch (fileType){
					case "audio/mpeg":
						System.out.println("MUSIC");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/music/"+listoffiles[i].getName());
						break;
					case "image/jpeg":
						System.out.println("PICTURE");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/pic/"+listoffiles[i].getName());
						break;
					case "video/mp4":
						System.out.println("VIDEO");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/video/"+listoffiles[i].getName());
						break;
					case "application/zip":
						System.out.println("ZIP");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/zip/"+listoffiles[i].getName());
						break;
					case "application/x-compressed-tar":
						System.out.println("ZIP");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/zip/"+listoffiles[i].getName());
						break;
					case "application/x-xz-compressed-tar":
						System.out.println("ZIP");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/zip/"+listoffiles[i].getName());
						break;
					case "application/x-bittorrent":
						System.out.println("TORRENTS");
						moveThem(""+listoffiles[i].toPath(),"/home/scripter/Downloads/torrents/"+listoffiles[i].getName());
						break;
					default:
						System.out.println("SORRY...... I don't know where to place the file with the extension "+fileType);
				}
				
    } catch (IOException ioException){
				System.out.println(ioException);
			}
		}
	
	}
}

