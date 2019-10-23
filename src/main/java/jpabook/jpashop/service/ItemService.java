package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> get(){
        return itemRepository.getAll();
    }

    @Transactional
    public void store(Item item){
        itemRepository.save(item);
    }

    public Item show(Long id){
        return itemRepository.find(id);
    }
}
