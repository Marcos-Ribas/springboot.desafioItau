package DesafioItau.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsDTO {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public StatisticsDTO(DoubleSummaryStatistics doubleSummaryStatistics){
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.max = doubleSummaryStatistics.getMax();
        this.min = doubleSummaryStatistics.getMin();
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
