package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ItemRepo;
import com.example.demo.model.Item;

@RestController
@RequestMapping("/api")
public class Controller
{
	@Autowired
	ItemRepo repo;
	
	@GetMapping("/items")
	public List<Item> listItems(){
		return repo.findAll();
	}
	
	@GetMapping("/item/{itemNo}")
	public Optional<Item> ReadItem(@PathVariable("itemNo") int id){
		return repo.findById(id);
	}
	
	@PostMapping("/item")
	public Item addItem(@RequestBody Item item){
		repo.save(item);
		return item;
	}
	@PutMapping("/item/withdrawal/{itemNo}/{amount}")
	public void withdrawalItem(@PathVariable("itemNo") int id , @PathVariable("amount") int amount) {
		Item item = repo.getOne(id);
		int a;
		if(item!=null)
			{
			a=item.getAmount();
			a-=amount;
			if(a>=0)
				{
				item.setAmount(a);
				repo.save(item);
				}
			}
	}
	
	@PutMapping("/item/deposit/{itemNo}/{amount}")
	public void depositItem(@PathVariable("itemNo") int id , @PathVariable("amount") int amount) {
		Item item = repo.getOne(id);
		if(item!=null)
			{
			amount+=item.getAmount();
			item.setAmount(amount);
			repo.save(item);
			}
	}
	
	@DeleteMapping("/item/{itemNo}")
	public void deleteItem(@PathVariable("itemNo") int id) {
		Item item = repo.getOne(id);
		repo.delete(item);
	}

}
