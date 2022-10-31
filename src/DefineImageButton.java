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

    Image listImage = new ImageIcon("assets/image/icons/list.png").getImage();
    Image liImage = listImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);

    ImageIcon listIcon = new ImageIcon(liImage);
    Image rhombusImage = new ImageIcon("assets/image/icons/菱形.png").getImage();
    Image rhImage = rhombusImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);

    ImageIcon rhombusIcon = new ImageIcon(rhImage);
    Image numberlistImage = new ImageIcon("assets/image/icons/number.png").getImage();
    Image nlImage = numberlistImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);

    ImageIcon numberlistIcon = new ImageIcon(nlImage);

    Image leftalignImage = new ImageIcon("assets/image/icons/leftalign.png").getImage();
    Image leImage = leftalignImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);

    ImageIcon leftalignIcon = new ImageIcon(leImage);
    Image centerImage = new ImageIcon("assets/image/icons/center.png").getImage();
    Image cenImage = centerImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);

    ImageIcon centerIcon = new ImageIcon(cenImage);



    Image rightalignImage = new ImageIcon("assets/image/icons/rightalign.png").getImage();
    Image riImage = rightalignImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);

    ImageIcon rightalignIcon = new ImageIcon(riImage);
}