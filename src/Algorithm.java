/**
 * Created by ned on 7/1/16.
 */
interface Algorithm {
    int run(final int[] items, Object... args);

    public String getName();

    public String getStats();
}
