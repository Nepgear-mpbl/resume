#sql("getPicIdByProjectId")
SELECT
  id
FROM r_picture
WHERE project_id = #para(0)
#end

#sql("getPicUrlById")
SELECT
  url
FROM r_picture
WHERE id = #para(0)
#end
