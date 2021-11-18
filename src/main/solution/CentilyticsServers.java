import java.util.LinkedList;
import java.util.Queue;

public class CentilyticsServers {

        static int noOfDayToUpdateAllServers(int variable, int[][] servers) {

            // Queue with functionality to store updated servers
            Queue<ServerRelationship> queue = new LinkedList<>();


            for(int A = 0; A < variable; A++)
            {
                for(int B = 0; B < variable; B++)
                {
                    if (servers[A][B] == 1)
                    {
                        queue.add(new ServerRelationship(A, B));
                    }
                }
            }

            //Initializing variable
            int noOfDaysToUpdateServers = 0;

            // To check that there are servers in the queue
            while (!queue.isEmpty())
            {
                int queueSize = queue.size();

               // un-updated servers adjacent to updated servers are updated
                while (queueSize-- > 0)
                {
                    ServerRelationship value = queue.peek();
                    queue.remove();

                    int serverA = value.serverOne;
                    int serverB = value.serverTwo;

                    if ((serverB > 0) && servers[serverA][serverB - 1] == 0)
                    {
                        servers[serverA][serverB - 1] = 1;
                        queue.add(new ServerRelationship(serverA, serverB - 1));
                    }


                    if ((serverA < variable - 1) && servers[serverA + 1][serverB] == 0)
                    {
                        servers[serverA + 1][serverB] = 1;
                        queue.add(new ServerRelationship(serverA + 1, serverB));
                    }

                    if ((serverB < variable - 1) && servers[serverA][serverB + 1] == 0)
                    {
                        servers[serverA][serverB + 1] = 1;
                        queue.add(new ServerRelationship(serverA, serverB + 1));
                    }

                    if ((serverA > 0) && servers[serverA - 1][serverB] == 0)
                    {
                        servers[serverA - 1][serverB] = 1;
                        queue.add(new ServerRelationship(serverA - 1, serverB));
                    }

                    if ((serverA > 0) && (serverB > 0) &&
                            servers[serverA - 1][serverB - 1] == 0)
                    {
                        servers[serverA - 1][serverB - 1] = 1;
                        queue.add(new ServerRelationship(serverA - 1, serverB - 1));
                    }

                    if ((serverA > 0) && (serverB < (variable - 1)) &&
                            servers[serverA - 1][serverB + 1] == 0)
                    {
                        servers[serverA - 1][serverB + 1] = 1;
                        queue.add(new ServerRelationship(serverA - 1, serverB + 1));
                    }

                    if ((serverA < (variable - 1)) && (serverB < (variable - 1)) &&
                            servers[serverA + 1][serverB + 1] == 0)
                    {
                        servers[serverA + 1][serverB + 1] = 1;
                        queue.add(new ServerRelationship(serverA + 1, serverB + 1));
                    }

                    if ((serverA < (variable - 1)) && (serverB > 0) &&
                            servers[serverA + 1][serverB - 1] == 0)
                    {
                        servers[serverA + 1][serverB - 1] = 1;
                        queue.add(new ServerRelationship(serverA + 1, serverB - 1));
                    }
                }

                noOfDaysToUpdateServers++;
            }
           int totalDaysToUpdateAllServers = noOfDaysToUpdateServers - 1;

            return totalDaysToUpdateAllServers;
        }
    }







