package algorithm;

import java.util.Date;

/**
 * Created by ned on 7/18/16.
 */
public class MeetingPlanner implements Algorithm {
    public int[] planMeeting(final int dur, final int[][] timesA, final int[][] timesB) {
        final int[] noMeeting = new int[0];

        if (1 > dur || null == timesA || null == timesB) {
            return noMeeting;
        }

        // Return the start and end times of the meeting,
        // being the earliest possibles

        // A meeting is possible when:
        // one of timesA span overlaps one of timesB span,
        // with a duration that ends on or before either end times

        // We need to check times in A and B

        // Compare both times
        int aIndex = 0;
        int bIndex = 0;

        // Iterate until reach the end of either
        while (aIndex < timesA.length && bIndex < timesB.length) {
            // Readability
            final int[] aTime = timesA[aIndex];
            final int[] bTime = timesB[bIndex];

            // Earliest start is the latest start; latest end is first end
            final int earliestStart = Math.max(aTime[0], bTime[0]);
            final int latestEnd = Math.min(aTime[1], bTime[1]);

            // Overlap is if (end - start) > 0
            // And valid meeting is if overlap >= duration
            if (latestEnd - earliestStart >= dur) {
                return new int[] { earliestStart, earliestStart + dur };
            }

            // These particular times didn't work;
            // Which next times to check? the later-ending one
            if (aTime[1] < bTime[1]) {
                aIndex++;
            } else {
                bIndex++;
            }
        }


//        for (int a = 0; a < timesA.length; a++) {
//            // Times give us seconds; Date needs millis
//            final Date startA = new Date(timesA[a][0] * 1000);
//            final Date endA = new Date(timesA[a][1] * 1000);
//
//            // Compare with B's availability
//            for (int b = 0; b < timesB.length; b++) {
//                final Date startB = new Date(timesB[b][0] * 1000);
//                final Date endB = new Date(timesB[b][1] * 1000);
//
//                // Determine if overlap of at least 'dur' secs
//                // Where overlap > dur
//                // overlap - dur >= 0
//
//                // Overlap:
//                // startA >= endB
//                // endA <= startB
//                //
//                // OR
//                //
//                // startB <= endA
//                // endB >= startA
//                p("Start A: " + startA);
//                p("Start B: " + startB);
//                p("A <= B? " + (startA.after(startB)));
//            }
//        }

        return noMeeting;
    }

    private static void p(final String s) {
        System.out.println(s);
    }


    @Override
    public String getName() {
        return "Meeting Planner";
    }

    @Override
    public String getStats() {
        return "TODO";
    }

    @Override
    public int getLastCount() {
        return 0;
    }
}
