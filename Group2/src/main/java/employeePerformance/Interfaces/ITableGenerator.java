package employeePerformance.Interfaces;

import java.util.List;
import java.util.Map;

public interface ITableGenerator
{
    public String generateTable(List<String> headersList, List<List<String>> rowsList,int... overRiddenHeaderHeight);
    void fillSpace(StringBuilder stringBuilder, int length);
    void createRowLine(StringBuilder stringBuilder,int headersListSize, Map<Integer,Integer> columnMaxWidthMapping);
    Map<Integer,Integer> getMaximumWidhtofTable(List<String> headersList, List<List<String>> rowsList);
    int getOptimumCellPadding(int cellIndex,int datalength,Map<Integer,Integer> columnMaxWidthMapping,int cellPaddingSize);
    void fillCell(StringBuilder stringBuilder,String cell,int cellIndex,Map<Integer,Integer> columnMaxWidthMapping);
}
