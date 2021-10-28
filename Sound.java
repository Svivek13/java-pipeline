package mu;

import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;
import javax.sound.*;

public class Sound{

	public static void success()
	{

		try{
			String songFile = "pika.wav";
			InputStream in = new FileInputStream(songFile);
			AudioStream a = new AudioStream(in);
			AudioPlayer.player.start(a);
		}
		catch(Exception e)
		{
              System.out.println("sucess problem");

              
		}
	}

	public static void failure()
	{

		try{
			String songFile = "pika3.wav";
			InputStream in = new FileInputStream(songFile);
			AudioStream a = new AudioStream(in);
			AudioPlayer.player.start(a);
		}
		catch(Exception e)
		{
		     System.out.println("failure problem");
		}
	}





















}