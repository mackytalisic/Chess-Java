package Chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Chess extends JPanel implements Runnable, MouseListener {

    static Chess starter = new Chess();
    int i = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chess");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(starter);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            starter.start();
            starter.init();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start() {

        setBackground(Color.magenta);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        addMouseListener(this);

        while(true) {
            repaint();
            i++;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private BufferedImage board;
    private BufferedImage title;
    private BufferedImage white_pawn;
    private BufferedImage white_king;
    private BufferedImage white_queen;
    private BufferedImage white_knight;
    private BufferedImage white_bishop;
    private BufferedImage white_rook;
    private BufferedImage black_pawn;
    private BufferedImage black_king;
    private BufferedImage black_queen;
    private BufferedImage black_knight;
    private BufferedImage black_bishop;
    private BufferedImage black_rook;


    private String[] whitePiece = new String[] {
            "♜",
            "♞",
            ""
    };

    private int[] place =  new int[] {-325,-245,-165,-85,-5,75,155,235};
    /**
     * <pre>
     *  ╔══╤══╤══╤══╤══╤══╤══╤══╗
     *  ║ 0│ 1│ 2│ 3│ 4│ 5│ 6│ 7║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║ 8│ 9│10│11│12│13│14│15║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║16│17│18│19│20│21│22│23║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║24│25│26│27│28│29│30│31║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║32│33│34│35│36│37│38│39║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║40│41│42│43│44│45│46│47║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║48│49│50│51│52│53│54│55║
     *  ╟──┼──┼──┼──┼──┼──┼──┼──╢
     *  ║56│57│58│59│60│61│62│63║
     *  ╚══╧══╧══╧══╧══╧══╧══╧══╝
     * </pre>
     */

    public void init() throws IOException {
        board = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/board.png")));
        //title = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/title.png")));

        white_pawn = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/white_pawn.png")));
        white_king = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/white_king.png")));
        white_queen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/white_queen.png")));
        white_knight = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/white_knight.png")));
        white_bishop = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/white_bishop.png")));
        white_rook = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/white_rook.png")));

        black_pawn = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/black_pawn.png")));
        black_king = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/black_king.png")));
        black_queen = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/black_queen.png")));
        black_knight = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/black_knight.png")));
        black_bishop = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/black_bishop.png")));
        black_rook = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Chess/image/black_rook.png")));
    }

    public void render(Graphics g) {

        g.setColor(new Color(245, 234, 200));
        g.fillRect(getWidth()/2 - 325,getHeight()/2 - 325,640,640);
        g.drawImage(board,getWidth()/2 - 325,getHeight()/2 - 325,640,640,null);
        g.drawImage(white_king,getWidth()/2 + 235,getHeight()/2 - 325,80,80,null);
        g.drawImage(black_king,getWidth()/2 - 245,getHeight()/2 - 325,80,80,null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

//        if (e.)
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
