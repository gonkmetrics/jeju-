package io.jejuwn.mapper;

import io.jejuwn.model.ProductLike;
import io.jejuwn.model.ProductLikeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductLikeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    long countByExample(ProductLikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int deleteByExample(ProductLikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int insert(ProductLike row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int insertSelective(ProductLike row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    List<ProductLike> selectByExample(ProductLikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    ProductLike selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int updateByExampleSelective(@Param("row") ProductLike row, @Param("example") ProductLikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int updateByExample(@Param("row") ProductLike row, @Param("example") ProductLikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int updateByPrimaryKeySelective(ProductLike row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_LIKE
     *
     * @mbg.generated Wed Jun 29 20:14:37 KST 2022
     */
    int updateByPrimaryKey(ProductLike row);
}