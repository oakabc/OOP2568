class Calculate {

public double calculateAverage (int [ ] arr) {

    double sum =0;
    double avg = 0;
    for (int i = 0; i < arr.length ; i++) {
        sum+=arr[i];
    }
    avg = sum/arr.length;

        return avg;
}

}

public class CalculateTest {

public static void main (String [] args) {

    int [ ] arr = {1,2,3,4,5,6,7,8,9,10};

    Calculate c = new Calculate();
   
    System.out.println(c.calculateAverage(arr));
    
}


}
