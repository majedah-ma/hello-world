package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
	public class Ships {
		Image img;
		ImageView node;
		
		public Ships(Image img) {
			this.img = img;
			node = new ImageView();
			node.setImage(this.img);
		}
		
		public ImageView getGraphic() {
			return node;
		}
	}
