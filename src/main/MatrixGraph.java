package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by lelay on 09.10.17.
 */
public class MatrixGraph implements SpecialValues {

    private int cityNumber;
    private double[][] matrixGraph;

    public int getCityNumber() {
        return cityNumber;
    }

    public MatrixGraph() {

    }

    public MatrixGraph(double[][] matrixGraph) {
        cityNumber = (int) Math.sqrt(matrixGraph.length);
        this.matrixGraph = matrixGraph;
    }

    public MatrixGraph(int cityNumber) {
        this.cityNumber = cityNumber;
        matrixGraph = new double[cityNumber][cityNumber];
        this.generateGraph();
    }

    public MatrixGraph(int cityNumber, int delta) {
        this.cityNumber = cityNumber;
        matrixGraph = new double[cityNumber][cityNumber];
        this.generateGraph(delta);
    }

    public void generateGraph(int delta) {
        Random rand = new Random();

        //is bi-directional for default
        for (int i = 0; i < cityNumber; i++) {
            for (int j = i + 1; j < cityNumber; j++) {
                matrixGraph[i][j] = new BigDecimal(rand.nextDouble() * delta).setScale(3, RoundingMode.UP).doubleValue();
                matrixGraph[j][i] = matrixGraph[i][j];
            }
            matrixGraph[i][i] = INF;
        }
    }

    //defaut value of the delta param is 100
    public void generateGraph() {
        this.generateGraph(100);
    }

    public void showMatrixGraph() {
        for (int i = 0; i < cityNumber; i++) {
            System.out.print(i + 1 + ": ");
            for (int j = 0; j < cityNumber; j++) {
                System.out.print(((matrixGraph[i][j] == INF) ? "INF\t" : matrixGraph[i][j]) + "\t| ");
            }
            System.out.println();
        }
    }

    public void setWeight(int i, int j, double weight) {
        matrixGraph[i][j] = weight;
    }

    public double getWeight(int i, int j) {
        return matrixGraph[i][j];
    }
}
