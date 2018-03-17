#sql("getDetailById")
SELECT
  *
FROM r_project_info
WHERE project_id = #para(0)
#end
