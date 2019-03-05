package com.students.utils;

import org.springframework.stereotype.Component;

import java.util.*;

class DTNode {
    private String attr;
    private String result;
    private String value;//到达该节点的特征值
    private ArrayList<DTNode> childNode;

    DTNode(){
        childNode = new ArrayList<DTNode>();
    }

    void setAttr(String attr){
        this.attr = attr;
    }

    String getAttr(){
        return this.attr;
    }

    void setResult(String result){
        this.result = result;
    }

    String getResult(){
        return this.result;
    }

    void setValue(String value){
        this.value = value;
    }

    String getValue(){
        return this.value;
    }

    void setChildNode(ArrayList<DTNode> childNode) {
        this.childNode = childNode;
    }

    ArrayList<DTNode> getChildNode() {
        return this.childNode;
    }
}

@Component
public class DecisionTree{
    private DTNode root;

    public int run(HashMap<String,HashMap<String,String>> data){
        if(root == null){
            return 0;
        }

        DTNode parentNode;
        ArrayList<DTNode> childNode;
        String value;
        int unhandledData = 0;//未处理的数据条数

        for(Map.Entry<String, HashMap<String, String>> d : data.entrySet()){
            parentNode = root;
            do{
                value = d.getValue().get(parentNode.getAttr());
                if(value == null){
                    d.getValue().put("quality", "-1");
                    unhandledData ++ ;
                    break;
                }
                childNode = parentNode.getChildNode();
                for(DTNode node : childNode){
                    if(node.getValue().equals(value)){
                        parentNode = node;
                        break;
                    }
                }
            }while(parentNode.getChildNode().size() != 0);
            d.getValue().put("quality", parentNode.getResult());
        }
        System.out.println(data);
        return unhandledData;
    }

    public DTNode createDTree(List<ArrayList<String>> data, List<String> attributeList){
/*        System.out.println("current data is: ");
        for(int i=0;i<data.size();i++){
            ArrayList<String> temp = data.get(i);
            for(int j=0;j<temp.size();j++){
                System.out.print(temp.get(j)+ " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        System.out.println("current attr is: ");
        for(int i=0;i<attributeList.size();i++){
            System.out.print(attributeList.get(i)+ " ");
        }
        System.out.println();
        System.out.println("---------------------------------");*/

        DTNode rNode = getNode(data, attributeList);
        this.root = rNode;
        return rNode;
    }

    public static void printDT(DTNode rNode){
        System.out.println("current node attr is: "+rNode.getAttr());
        System.out.println("current node result is: "+rNode.getResult());
        System.out.println("current node value is "+rNode.getValue());
        ArrayList<DTNode> al = rNode.getChildNode();
        if(al!=null && al.size()>0){
            System.out.println("current node has childnode: ");
            System.out.println("---------------------------------");
            for(DTNode als: al){
                printDT(als);
            }
        }
    }

    public static DTNode getNode(List<ArrayList<String>> data,List<String> attributeList){

/*        System.out.println("current data is: ");
        for(int i=0;i<data.size();i++){
            ArrayList<String> temp = data.get(i);
            for(int j=0;j<temp.size();j++){
                System.out.print(temp.get(j)+ " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        System.out.println("current attr is: ");
        for(int i=0;i<attributeList.size();i++){
            System.out.print(attributeList.get(i)+ " ");
        }
        System.out.println();
        System.out.println("---------------------------------");*/

        DTNode dn = new DTNode();
        ArrayList<DTNode> childNode;

        if(isPure(data)){
            if(data.size()>0)
                dn.setResult(getDataRes(data));
            return dn;
        }


        int attrIndex = getAttr(data,attributeList);
        childNode = getChildNode(data,attributeList,attrIndex);

        dn.setAttr(attributeList.get(attrIndex));
        dn.setChildNode(childNode);
        return dn;
    }

    public static String getDataRes(List<ArrayList<String>> data){
        ArrayList<String> tempAL = data.get(0);
        String res = tempAL.get(tempAL.size()-1);
        return res;

    }

    public static boolean isPure(List<ArrayList<String>> data){
        HashSet<String> hs = new HashSet<String>();
        for(ArrayList<String> al: data){
            String as = al.get(al.size()-1);
            hs.add(as);
        }
        if(hs.size()>1){
            return false;
        }
        return true;
    }

    public static ArrayList<DTNode> getChildNode(List<ArrayList<String>> data,List<String> attributeList, int i){

        ArrayList<DTNode> childNode = new ArrayList<DTNode>();

        String attrValue = attributeList.get(i);
        List<String> attributeList2 = new ArrayList<String>();

        //删除将要用于分裂的属性，得到新的属性集
        for(String als: attributeList){
            if(!als.equals(attrValue)){
                attributeList2.add(als);
            }
        }

        HashMap<String,List<ArrayList<String>>> hm = new HashMap<String,List<ArrayList<String>>>();
        for(ArrayList<String> d: data){
            String attv = d.get(i);
            d.remove(i);
            if(hm.get(attv)==null){
                List<ArrayList<String>> ll = new ArrayList<ArrayList<String>>();
                ll.add(d);
                hm.put(attv, ll);
            }else{
                List<ArrayList<String>> ll = hm.get(attv);
                ll.add(d);
                hm.put(attv, ll);
            }

        }

        for(Map.Entry<String,List<ArrayList<String>>> hms:hm.entrySet()){
            List<ArrayList<String>> tempdata = hms.getValue();
            DTNode dtn = getNode(tempdata,attributeList2);
            dtn.setValue(hms.getKey());
            childNode.add(dtn);
        }

        return childNode;
    }


    /*选择下一个分裂属性*/
    public static int getAttr(List<ArrayList<String>> data,List<String> attributeList){
        Double gain = gainData(data);
        double maxSub = 0.0;
        int aindex = 0;
        int length = attributeList.size();
        for(int i=0; i< length-1; i++){
            HashMap<String,HashMap<String,Integer>> hm = sepData(data,i);
            Double gaintemp = gaintemp(hm);
            double tempSub = gain - gaintemp;
            if(tempSub>maxSub){
                maxSub = tempSub;
                aindex = i;
            }

        }
        return aindex;
    }

    public static HashMap<String,HashMap<String,Integer>> sepData(List<ArrayList<String>> data,int i){
        HashMap<String,HashMap<String,Integer>> hm = new HashMap<String,HashMap<String,Integer>>();
        for(ArrayList<String> d:data){
            String att = d.get(i);
            String res = d.get(d.size()-1);
            if(hm.get(att)==null){
                HashMap<String,Integer> hmm = new HashMap<String,Integer>();
                hmm.put(res, 1);
                hm.put(att, hmm);
            }else{
                if(hm.get(att).get(res)==null){
                    hm.get(att).put(res, 1);
                }else{
                    hm.get(att).put(res, hm.get(att).get(res)+1);
                }
            }
        }
        return hm;
    }

    public static Double gaintemp(HashMap<String,HashMap<String,Integer>> hm){
        double regainValue = 0.0;
        double resum = 0.0;

        ArrayList<Double> a= new ArrayList<Double>();
        ArrayList<Double> b= new ArrayList<Double>();

        for(Map.Entry<String, HashMap<String,Integer>> entry:hm.entrySet()){
            HashMap<String,Integer> hmm = entry.getValue();
            double gainValue = 0.0;
            double sum = 0.0;
            for(Map.Entry<String, Integer> eentry:hmm.entrySet()){
                sum+=(double)eentry.getValue();
            }
            for(Map.Entry<String, Integer> eentry:hmm.entrySet()){
                double eev = (double)eentry.getValue();
                gainValue -= eev/sum*Math.log(eev/sum);
            }

            a.add(sum);
            b.add(gainValue);
            resum+= sum;
        }


        for(int i=0; i<a.size();i++){
            double aa = a.get(i);
            double bb = b.get(i);
            regainValue += aa/resum*bb;
        }


        return regainValue;
    }

    public static Double gainData(List<ArrayList<String>> data){
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        int size = data.size();
        double gainValue = 0.0;
        for(ArrayList<String> d: data){
            String result = d.get(d.size()-1);
            if(hm.get(result)==null){
                hm.put(result, 1);
            }else{
                hm.put(result, hm.get(result)+1);
            }
        }

        for(Map.Entry<String, Integer> entry:hm.entrySet()){
            int kv = entry.getValue();
            double tempD = (double)kv/(double)size*Math.log((double)kv/(double)size);
            gainValue -= tempD;
        }
        return gainValue;
    }
}
