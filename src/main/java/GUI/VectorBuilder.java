/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author Milton
 */
public class VectorBuilder
{

    private Rectangle2D schermformaat;

    public VectorBuilder(Rectangle2D schermformaat) {
        this.schermformaat = schermformaat;
    }

    public SVGPath rijtechniekG(Color kleur) {
        SVGPath path = new SVGPath();
        path.setContent("m 208.95117,448.92236 q 0,12.12891 -8.52539,19.95118 -8.52539,7.73437 -21.00586,7.73437 -12.48047,0 -21.00586,-7.82227 -8.52539,-7.82226 -8.52539,-19.86328 0,-11.42578 9.14063,-19.07226 -6.5918,-5.44922 -6.5918,-14.23828 0,-10.98633 7.73437,-18.10547 7.82227,-7.11914 19.24805,-7.11914 11.33789,0 19.16016,7.11914 7.82226,7.11914 7.82226,18.10547 0,9.75586 -6.67968,14.23828 9.22851,7.38281 9.22851,19.07226 z m -20.91797,-32.7832 q 0,-3.51562 -2.54883,-6.06445 -2.54882,-2.54883 -6.06445,-2.54883 -3.51562,0 -6.15234,2.54883 -2.54883,2.54883 -2.54883,6.06445 0,3.51563 2.54883,6.15234 2.63672,2.54883 6.15234,2.54883 3.51563,0 6.06445,-2.54883 2.54883,-2.63671 2.54883,-6.15234 z m 1.84571,32.95898 q 0,-4.13085 -3.16407,-7.29492 -3.16406,-3.16406 -7.29492,-3.16406 -4.21875,0 -7.38281,3.16406 -3.07617,3.16407 -3.07617,7.29492 0,4.21875 3.07617,7.38282 3.16406,3.07617 7.38281,3.07617 4.13086,0 7.29492,-3.07617 3.16407,-3.16407 3.16407,-7.38282 z");
        path.setFill(kleur);
        return path;
    }

    public Group buildKnop(Color kleur) {
        Group out = new Group();

        SVGPath bolleken = new SVGPath();
        bolleken.setContent("m 536.20528,419.93689 a 36.494186,36.494186 0 0 1 -36.49419,36.49419 36.494186,36.494186 0 0 1 -36.49419,-36.49419 36.494186,36.494186 0 0 1 36.49419,-36.49419 36.494186,36.494186 0 0 1 36.49419,36.49419 z");
        bolleken.setFill(kleur);
        bolleken.setStroke(Color.BLACK);
        bolleken.setStrokeWidth(1);
        SVGPath knop1 = new SVGPath();
        knop1.setContent("m 251.10104,401.31512 251.72651,0 c 6.9279,0 12.50524,5.57735 12.50524,12.50525 l 0,252.44074 c 0,6.92791 -5.57734,12.50525 -12.50524,12.50525 l -251.72651,0 c -6.9279,0 -12.50525,-5.57734 -12.50525,-12.50525 l 0,-252.44074 c 0,-6.9279 5.57735,-12.50525 12.50525,-12.50525 z");
        knop1.setFill(kleur);
        SVGPath knop2 = new SVGPath();
        knop2.setContent("m 247.44433,397.22537 259.60627,0 c 7.16782,0 12.93831,5.77049 12.93831,12.93831 l 0,261.18274 c 0,7.16783 -5.77049,12.93831 -12.93831,12.93831 l -259.60627,0 c -7.16782,0 -12.9383,-5.77048 -12.9383,-12.93831 l 0,-261.18274 c 0,-7.16782 5.77048,-12.93831 12.9383,-12.93831 z");
        knop2.setFill(Color.LIGHTGRAY);
        SVGPath knop3 = new SVGPath();
        knop3.setContent("m 243.30173,391.70871 268.1007,0 c 7.4344,0 13.4195,5.9851 13.4195,13.4195 l 0,270.89656 c 0,7.43441 -5.9851,13.4195 -13.4195,13.4195 l -268.1007,0 c -7.4344,0 -13.4195,-5.98509 -13.4195,-13.4195 l 0,-270.89656 c 0,-7.4344 5.9851,-13.4195 13.4195,-13.4195 z");
        knop3.setFill(Color.BLACK);

        out.getChildren().addAll(knop3, knop2, knop1, bolleken);

        out.setScaleX(0.5);
        out.setScaleY(0.5);
        out.autoSizeChildrenProperty().set(true);

        return out;

    }

    public Group buildHoekLinks() {
        Group out = new Group();
        SVGPath path = new SVGPath();
        path.setContent("m 462.52731,265.69847 -155.44094,47.23207 c -120.85661,169.50001 -98.55946,337.25424 1.01016,504.06612 L 487.49578,875.8201 C 340.43191,692.01746 310.78235,495.26462 462.52731,265.69847 Z");
        path.setFill(Color.BLACK);
//        path.setTranslateX(0);
        scaleVierkant(path, 1);
        out.getChildren().add(path);
        return out;
    }

    public void scaleVierkant(SVGPath g, double scale) {
        g.setScaleX(scale);
        g.setScaleY(scale);
    }

}
