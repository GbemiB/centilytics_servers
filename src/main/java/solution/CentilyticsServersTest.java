package solution;

public class CentilyticsServersTest {

    public static void main(String[] args) {

        int variable = 3;
        int[][] servers =
                {
                        {1, 0, 1},
                        {0, 0, 0},
                        {0, 0, 1}
                };

        int noOfDaysToUpdateServers = CentilyticsServers.noOfDayToUpdateAllServers(variable, servers);

        System.out.print(noOfDaysToUpdateServers);

    }
}
