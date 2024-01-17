import java.util.List;

public interface IStatistics<T> {
    void getStatistics(List<T> str , String statisticsName , boolean minState , boolean fulState);

}
