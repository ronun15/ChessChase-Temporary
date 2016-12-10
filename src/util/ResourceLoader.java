package util;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import model.EntityState;

public class ResourceLoader
{
	private static ResourceLoader instance = new ResourceLoader();
	
	private ResourceLoader()
	{
		
//		Should be called at program's start
//		loadResources();
	}

	public static ResourceLoader getInstance()
	{
		return instance;
	}
	
	private List<List<Image>> playerSprites, pawnSprites, rookSprites, knightSprites, bishopSprites, queenSprites, kingSprites;
	
	public void loadResources()
	{
		playerSprites = new ArrayList<>();
		pawnSprites = new ArrayList<>();
		rookSprites = new ArrayList<>();
		knightSprites = new ArrayList<>();
		bishopSprites = new ArrayList<>();
		queenSprites = new ArrayList<>();
		kingSprites = new ArrayList<>();
		
		fillSprites(playerSprites, Config.PLAYER_PATH);
		fillSprites(pawnSprites, Config.PAWN_PATH);
		fillSprites(rookSprites, Config.ROOK_PATH);
		fillSprites(knightSprites, Config.KNIGHT_PATH);
		fillSprites(bishopSprites, Config.BISHOP_PATH);
		fillSprites(queenSprites, Config.QUEEN_PATH);
		fillSprites(kingSprites, Config.KING_PATH);
	}
	
	private void fillSprites(List<List<Image>> list, String path)
	{
		System.out.println(path);
		for(EntityState state : EntityState.values())
		{
			if(state != EntityState.CREATED)
			{
				try
				{
					System.out.println(path + Config.getSpriteFileName(state));
					System.out.println(ClassLoader.getSystemResource(path + Config.getSpriteFileName(state)));
					Image image = new Image(ClassLoader.getSystemResource(path + Config.getSpriteFileName(state)).toString());
					list.add(state.getIndex(), new ArrayList<>());
					for(int i=0; i<list.get(state.getIndex()).size(); i++)
						list.get(state.getIndex()).add(i, new WritableImage(image.getPixelReader(), i * (int) image.getWidth() / list.get(state.getIndex()).size(), 0, (int) image.getWidth(), (int) image.getHeight()));
					System.out.println(list.get(state.getIndex()).toString());
				}
				catch(NullPointerException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public Image getPlayerSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return playerSprites.get(state.getIndex()).get(0);
			default:
				return playerSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public Image getPawnSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return pawnSprites.get(state.getIndex()).get(0);
			default:
				return pawnSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public Image getRookSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return rookSprites.get(state.getIndex()).get(0);
			default:
				return rookSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public Image getKnightSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return knightSprites.get(state.getIndex()).get(0);
			default:
				return knightSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public Image getBishopSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return bishopSprites.get(state.getIndex()).get(0);
			default:
				return bishopSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public Image getQueenSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return queenSprites.get(state.getIndex()).get(0);
			default:
				return queenSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public Image getKingSprite(EntityState state, int frame)
	{
		switch(state)
		{
			case DYING:
			case IDLE:
				return kingSprites.get(state.getIndex()).get(0);
			default:
				return kingSprites.get(state.getIndex()).get(frame);
		}
	}
	
	public static void main(String[] args)
	{
		getInstance().loadResources();
	}
}
