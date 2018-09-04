package com.example.api.service;

import com.example.api.entities.cast.CastContents;
import com.example.api.repositories.cast.CastMapper;
import com.example.api.repositories.cast.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CastService {

    private CastRepository castRepository;
    private CastMapper castMapper;

    @Autowired
    public CastService(CastRepository castRepository, CastMapper castMapper) {
        this.castRepository = castRepository;
        this.castMapper = castMapper;
    }

    public void getCastList() {

        // JPA
        //List<CastContents> castContentsList = castRepository.findAll();

        // Mybatis
        List<CastContents> castContentsList = castMapper.getCastLists();

        HashMap<Integer, HashMap<Integer, CastContents>> castLists = new HashMap<>();
        HashMap<Integer, CastContents> list = new HashMap<>();
        int k = 0;
        int i = 0;
        int a = 0;
        int entKey = castContentsList.size();

        for (CastContents value : castContentsList) {

            list.put(i, value);

            if((i + 1) % 7 == 0) {
                castLists.put(k, (HashMap<Integer, CastContents>) list.clone());
                list.clear();
                k++;
                i=0;
            } else i++;

            a++;
            if(entKey == a) {
                castLists.put(k, (HashMap<Integer, CastContents>) list.clone());
            }

        }


       // System.out.println("########최종#########");
        //System.out.println(castLists);

        int lastCastLists = castLists.size();
        //System.out.println(lastCastLists);
        List<String> boardIdNameStorage = new ArrayList<>();
        castLists.forEach((key, value) -> {

            value.forEach((childrenKey, childrenValue) -> {
                if(key != lastCastLists) {

                    String boardIdName = childrenValue.getBoardId();
                    boardIdNameStorage.add(boardIdName);
                    HashMap<String, Integer> countBoardIdName = arrayCountValues(boardIdNameStorage);

                    //System.out.println(countBoardIdName);

                    HashMap<String, Integer> breachCategoriesData = getBreachCategoriesData(countBoardIdName);
                    if(breachCategoriesData.size() > 0) {
                        HashMap<Integer, CastContents> nextCastLists = castLists.get(key+1);
                        //HashMap<Integer, CastContents> replaceCastLists = duplicateValidator(nextCastLists, breachCategoriesData, countBoardIdName);


                        //List<CastContents> replaceCastLists = duplicateValidator(nextCastLists, breachCategoriesData, countBoardIdName);

                        //System.out.println(childrenValue);
                        //System.out.println(replaceCastLists);
                        //System.out.println("################################");
                        //HashMap<Integer, CastContents> cloneReplaceCastLists = (HashMap<Integer, CastContents>) replaceCastLists.clone();



                        List cloneReplaceCastLists = new ArrayList();
                        List cloneReplaceCastLists2 = new ArrayList();
                        //cloneReplaceCastLists.add(replaceCastLists);
                        //cloneReplaceCastLists2.add(childrenValue);

                        //castLists.get(key).remove(childrenValue);
                        //castLists.get(key+1).remove(replaceCastLists);


                        //castLists.get(key+1).put((int) castLists.get(key+1).size()+1, childrenValue);
                        //castLists.get(key).put((int) childrenKey, replaceCastLists.get(0));

                        boardIdNameStorage.remove(childrenValue.getBoardId());
                    }

                    //System.out.println(breachCategoriesData);

                } else {

                }


                  //  System.out.println(childrenValue);
            });
            boardIdNameStorage.clear();
        });
        System.out.println(castLists);
    }

    private List<CastContents> duplicateValidator(HashMap<Integer, CastContents> nextCastLists,
                                    HashMap<String, Integer> breachCategoriesData,
                                    HashMap<String, Integer> countBoardIdName) {
        //HashMap<Integer, CastContents> returnList = new HashMap<>();
        List<CastContents> returnList = new ArrayList<>();



        //System.out.println(nextCastLists);
        Set<Map.Entry<Integer, CastContents>> entries = nextCastLists.entrySet();
        Iterator<Map.Entry<Integer, CastContents>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<Integer, CastContents> entry = i.next();
            //System.out.println(entry.getKey()+" : "+entry.getValue());
            if(!breachCategoriesData.containsKey(entry.getValue().getBoardId()) && (!countBoardIdName.containsKey(entry.getValue().getBoardId()) || countBoardIdName.get(entry.getValue().getBoardId()) < 3 )) {
                //  System.out.println(value.getBoardId());

                //returnList.put(entry.getKey(), entry.getValue());
                returnList.add(entry.getValue());
                break;
            }
        }
        return returnList;
/*
        nextCastLists.forEach((key, value) -> {
            //System.out.println(countBoardIdName);
            if(!breachCategoriesData.containsKey(value.getBoardId()) && (!countBoardIdName.containsKey(value.getBoardId()) || countBoardIdName.get(value.getBoardId()) < 3 )) {
              //  System.out.println(value.getBoardId());

                returnList.put(key, value);

            }

        });*/

        //return returnList;
    }

    private HashMap<String, Integer> getBreachCategoriesData(HashMap<String, Integer> countBoardIdName) {
        HashMap<String, Integer> list = new HashMap<>();
        countBoardIdName.forEach((key, value) -> {
            if(value > 3) {
                list.put(key, value);
            }
        });
        return list;
    }

    private HashMap<String, Integer> arrayCountValues(List<String> boardIdNameStorage) {

        HashMap<String, Integer> list = new HashMap<>();
        boardIdNameStorage.forEach((value) -> {
            int count = (list.containsKey(value)) ? (list.get(value) + 1) : 1;
            list.put(value, count);
        });
        return list;
    }

}
