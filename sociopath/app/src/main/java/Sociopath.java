import java.util.List;

public class Sociopath {


    public int findTheSociopath(int groupSize, List<int[]> likeList) {

  
        if (groupSize <= 1) {
            return -1;
        }

  
        int[] likesCount = new int[groupSize + 1];   
        boolean[] likesSomeone = new boolean[groupSize + 1]; 

        for (int[] pair : likeList) {
            if (pair.length != 2) return -1;

            int liker = pair[0];
            int liked = pair[1];

            if (liker < 1 || liker > groupSize || liked < 1 || liked > groupSize) {
                return -1; 
            }

            likesSomeone[liker] = true;
            likesCount[liked]++;
        }


        for (int person = 1; person <= groupSize; person++) {
            if (!likesSomeone[person] && likesCount[person] == groupSize - 1) {
                return person;
            }
        }

        return -1; 
    }
}
