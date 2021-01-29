package demo;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StringList 解析监听器
 * @author HaungLongPu
 * @since 2020-12-11
 */
public class StringArrayExcelReadListener extends AnalysisEventListener<Map<String, String>> {

    /**
     * 存储读取到的表头
     */
    private List<String> head = new ArrayList<>();
    /**
     * 存储读取到的 Excel 数据
     */
    private List<List<String>> data = new ArrayList<>();

    /**
     * 每解析一行都会回调invoke()方法
     * @param item  读取后的数据对象
     * @param context 内容
     */
    @Override
    public void invoke(Map<String, String> item, AnalysisContext context) {
        if(item != null && !item.isEmpty()) {
            List<String> info = item.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
            data.add(info);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    /**
     * 处理读取到的表头数据
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        if(headMap != null && !headMap.isEmpty()) {
            head = headMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        }
    }

    /**
     * 获取表头数据信息
     * @return
     */
    public List<String> getHead() {
        return this.head;
    }

    /**
     * 获取读取到的 Excel 数据
     * @return
     */
    public List<List<String>> getData() {
        return this.data;
    }
}