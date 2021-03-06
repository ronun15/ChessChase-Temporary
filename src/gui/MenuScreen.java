/**
 * PROG METH 2110215
 * Project: Chess Chase
 * @author Vivattanachai Sangsa-nga 5831065021, Attawit Chaiyaroj 5831079921
 */

package gui;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import util.Config;
import util.ResourceLoader;

public class MenuScreen extends StackPane{
	private static final int BACKGROUND_OFFSET = 400;
	
	private Canvas canvasFront,canvasBack;
	private GraphicsContext gcFront,gcBack;
	private Image frontImage,backgroundImage;
	
	public MenuScreen(){
		frontImage = ResourceLoader.getFrontTitleImage();
		backgroundImage = ResourceLoader.getBackTitleImage();
		
		canvasFront = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		canvasBack = new Canvas(backgroundImage.getWidth(), backgroundImage.getHeight());
		
		this.setPrefSize(backgroundImage.getWidth(), backgroundImage.getHeight());
		this.getChildren().add(canvasBack);
		this.getChildren().add(canvasFront);
		
		gcFront = canvasFront.getGraphicsContext2D();
		gcFront.drawImage(frontImage, 0, 0);
		
		gcBack = canvasBack.getGraphicsContext2D();
		gcBack.drawImage(backgroundImage, 0, 0);
		
		StackPane.setMargin(canvasBack, new Insets(BACKGROUND_OFFSET, 0, 0, 0));
		
		rotateBackground(gcBack);
	}
	
	public void rotateBackground(GraphicsContext gc){
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				gc.getCanvas().getTransforms().add(new Rotate(0.75, backgroundImage.getWidth() / 2, (backgroundImage.getHeight() / 2) ));
			}
		}.start();
	}
}
