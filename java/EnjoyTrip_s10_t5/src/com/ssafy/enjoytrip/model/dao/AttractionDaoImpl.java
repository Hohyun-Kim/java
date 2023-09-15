package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {
	
	private static AttractionDao attractionDao = new AttractionDaoImpl();
	
	private AttractionDaoImpl() {
		
	}
	
	public static AttractionDao getAttractionDao() {
		return attractionDao;
	}

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			int sidoCode = attractionInfoDto.getSidoCode();
			int contentTypeId = attractionInfoDto.getContentTypeId();
			int[] param = {sidoCode, contentTypeId};
			boolean[] exist = new boolean[2];
			
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from attraction_info \n");
			if((sidoCode != 0) || (contentTypeId != 0)) {
				sql.append("where ");
			}
			if(attractionInfoDto.getSidoCode() != 0) {
				sql.append("sido_code = ?\n");
				exist[0] = true;
			}
			if((attractionInfoDto.getSidoCode() != 0) && (attractionInfoDto.getContentTypeId() != 0)) sql.append("and ");
			if(attractionInfoDto.getContentTypeId() != 0) {
				sql.append("content_type_id = ?");
				exist[1] = true;
			}
			pstmt = conn.prepareStatement(sql.toString());
			int cnt = 0;
			for(int i = 0; i < 2; i++) {
				if(exist[i]) pstmt.setInt(++cnt, param[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AttractionInfoDto aidto = new AttractionInfoDto();
				aidto.setContentId(rs.getInt("content_id"));
				aidto.setContentTypeId(rs.getInt("content_type_id"));
				aidto.setTitle(rs.getString("title"));
				aidto.setAddr1(rs.getString("addr1"));
				aidto.setAddr2(rs.getString("addr2"));
				aidto.setZipcode(rs.getString("zipcode"));
				aidto.setTel(rs.getString("tel"));
				aidto.setFirstImage(rs.getString("first_image"));
				aidto.setFirstImage2(rs.getString("first_image2"));
				aidto.setReadcount(rs.getInt("content_id"));
				aidto.setSidoCode(rs.getInt("content_type_id"));
				aidto.setGugunCode(rs.getInt("gugun_code"));
				aidto.setLatitude(rs.getDouble("latitude"));
				aidto.setLongitude(rs.getDouble("longitude"));
				aidto.setMlevel(rs.getString("mlevel"));
				list.add(aidto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			boolean exist = false;
			
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from attraction_info \n");
			sql.append("where title like ?\n");
			if(sidoCode != 0) {
				sql.append("and sido_code = ?\n");
			}
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+title+"%");
			if(sidoCode != 0) {
				pstmt.setInt(2, sidoCode);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AttractionInfoDto aidto = new AttractionInfoDto();
				aidto.setContentId(rs.getInt("content_id"));
				aidto.setContentTypeId(rs.getInt("content_type_id"));
				aidto.setTitle(rs.getString("title"));
				aidto.setAddr1(rs.getString("addr1"));
				aidto.setAddr2(rs.getString("addr2"));
				aidto.setZipcode(rs.getString("zipcode"));
				aidto.setTel(rs.getString("tel"));
				aidto.setFirstImage(rs.getString("first_image"));
				aidto.setFirstImage2(rs.getString("first_image2"));
				aidto.setReadcount(rs.getInt("content_id"));
				aidto.setSidoCode(rs.getInt("content_type_id"));
				aidto.setGugunCode(rs.getInt("gugun_code"));
				aidto.setLatitude(rs.getDouble("latitude"));
				aidto.setLongitude(rs.getDouble("longitude"));
				aidto.setMlevel(rs.getString("mlevel"));
				list.add(aidto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return list;
	}

}
