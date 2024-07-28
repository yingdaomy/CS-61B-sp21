public class DrawTriangle {

    public static void DrawTriangle(int n) {
    /** Print a triangle with a length of n.
     *  @Author YingDaomy
     * @parm n: the length of the triangle
     *  */
        for (int i = 1; i <= n; i += 1) {
            for (int j = 1; j <= i; j += 1) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DrawTriangle(10);
    }
}
