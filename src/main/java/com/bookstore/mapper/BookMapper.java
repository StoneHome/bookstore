package com.bookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bookstore.bean.Book;

public interface BookMapper {

	@Select("select * from bs_book where id = #{id}")
	public Book selectBookById(int id);

	@Select("select * from bs_book")
	public List<Book> selectBookList();

	@Select({"<script>",
	"select count(*) from bs_book ",
	"<if test='minPrice!=null and maxPrice!=null'>",
	"where price between #{minPrice} and #{maxPrice} ",
	"</if>",
	"</script>"})
	public long getPageBookCount(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
	
	@Select({"<script>",
		"select * from bs_book ",
		"<if test='minPrice!=null and maxPrice!=null'>",
		"where price between #{minPrice} and #{maxPrice} ",
		"</if>",
		"limit #{start}, #{size}",
		"</script>"})
	public List<Book> getPageBookList(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, @Param("start") int start, @Param("size") int size);

	@Insert("insert into bs_book(title, author, price, sales, stock, imgPath) values(#{title}, #{author}, #{price}, #{sales}, #{stock}, #{imgPath})")
	public Book insertBook(Book book);

	@Delete("delete from bs_book where id = #{id}")
	public void deleteBook(int id);

	@Update("update bs_book set title = #{title}, author = #{author}, price = #{price}, sales = #{sales}, stock = #{stock} where id = #{id}")
	public void updateBook(Book book);

	@Update("update bs_book set imgPath = #{imgPath} where id = #{id}")
	public void updateBookImgPath(@Param("id") int id, @Param("imgPath") String imgPath);
}
