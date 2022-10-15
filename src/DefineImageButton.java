import javax.swing.*;
import java.awt.*;

public class DefineImageButton {
    //定義圖片
    Image image=new ImageIcon("assets/image/icons/new.png").getImage();
    Image nImage=image.getScaledInstance(20,20, Image.SCALE_AREA_AVERAGING);
    ImageIcon newIcon=new ImageIcon(nImage);
    Image undoImage=new ImageIcon("assets/image/icons/undo.png").getImage();
    Image uImage=undoImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);
    ImageIcon undoIcon=new ImageIcon(uImage);
    Image boldImage = new ImageIcon("assets/image/icons/bold.png").getImage();
    Image bImage = boldImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);
    ImageIcon boldIcon = new ImageIcon(bImage);
    Image italicsImage = new ImageIcon("assets/image/icons/italics.png").getImage();
    Image iImage = italicsImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);
    ImageIcon italicsIcon = new ImageIcon(iImage);
    Image bottomlineImage = new ImageIcon("assets/image/icons/bottomline.png").getImage();
    Image boImage = bottomlineImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);
    ImageIcon bottomlineIcon = new ImageIcon(boImage);
}