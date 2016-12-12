package util;

import javafx.scene.media.AudioClip;

public class AudioUtility
{
	private static AudioUtility instance = new AudioUtility();
	private AudioClip currentBGM, currentSFX;
	
	private AudioUtility()
	{
		currentBGM = ResourceLoader.getInstance().getMenuBGM();
		currentSFX = ResourceLoader.getInstance().getGameOverSound();
	}

	private static AudioUtility getInstance()
	{
		return instance;
	}
	
	public static void playBGM(AudioClip bgm)
	{
		if(getInstance().currentBGM.isPlaying()) AudioUtility.stopBGM();
		getInstance().currentBGM = bgm;
		getInstance().currentBGM.setCycleCount(AudioClip.INDEFINITE);
		getInstance().currentBGM.play();
	}
	
	public static void playMenuBGM()
	{
		AudioUtility.playBGM(ResourceLoader.getInstance().getMenuBGM());
	}
	
	public static void playGameBGM()
	{
		AudioUtility.playBGM(ResourceLoader.getInstance().getGameBGM());
	}
	
	public static void stopBGM()
	{
		getInstance().currentBGM.stop();
	}
	
	public static void playSoundEffect(AudioClip sound)
	{
		if(getInstance().currentSFX.isPlaying()) AudioUtility.stopSoundEffect();
		getInstance().currentSFX = sound;
		getInstance().currentSFX.play();
	}
	
	public static void stopSoundEffect()
	{
		getInstance().currentSFX.stop();
	}

	public static void playGameOverSound()
	{
		AudioUtility.stopBGM();
		AudioUtility.playSoundEffect(ResourceLoader.getInstance().getGameOverSound());
	}
	
	public static void playBurstLinkSound()
	{
		AudioUtility.playSoundEffect(ResourceLoader.getInstance().getBurstLinkSound());
	}
	
	public static void playTripleAccelSound()
	{
		AudioUtility.playSoundEffect(ResourceLoader.getInstance().getTripleAccelSound());
	}
}
