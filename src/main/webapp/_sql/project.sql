#sql("getAllProjectInfo")
SELECT
  *
FROM r_project
#end

#sql("getInfoById")
SELECT
  *
FROM r_project
WHERE id = #para(0)
#end

#sql("getAllProjectId")
SELECT
  id
FROM r_project
#end
