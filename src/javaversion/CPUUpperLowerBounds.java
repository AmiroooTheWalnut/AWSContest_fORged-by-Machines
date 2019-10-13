/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaversion;

/**
 *
 * @author user
 */
public class CPUUpperLowerBounds {
    public int startIndex;
    public int endIndex;
    
    public static CPUUpperLowerBounds[] spreadTasks(int numCPUs, int numTasks) {
        CPUUpperLowerBounds output[] = new CPUUpperLowerBounds[numCPUs];
        for (int i = 0; i < numCPUs; i++) {
            output[i] = new CPUUpperLowerBounds();
        }
        if (numCPUs < numTasks) {
            if (numCPUs > 2) {
                int step = (int) Math.floor(((numTasks) / numCPUs));
                for (int i = 0; i < numCPUs - 1; i++) {
                    output[i].startIndex = i * step;
                    output[i].endIndex = (i + 1) * step;
                }
//            System.out.println();
                output[numCPUs - 1].startIndex = output[numCPUs - 2].endIndex;
                output[numCPUs - 1].endIndex = numTasks;
            } else if (numCPUs == 2) {
                output[0].startIndex = 0;
                output[0].endIndex = (int) Math.floor(((numTasks) / numCPUs));
                output[numCPUs - 1].startIndex = output[numCPUs - 2].endIndex;
                output[numCPUs - 1].endIndex = numTasks;
            } else if (numCPUs == 1) {
                output[0].startIndex = 0;
                output[0].endIndex = numTasks;
            }
        } else {
            for (int i = 0; i < numTasks; i++) {
                output[i].startIndex = i;
                output[i].endIndex = i + 1;
            }
        }
        return output;
    }
    
}
