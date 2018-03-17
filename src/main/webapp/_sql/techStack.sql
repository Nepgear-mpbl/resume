#sql("getTechStackById")
SELECT
  *
FROM r_tech_stack
WHERE project_id = #para(0)
#end

#sql("getTechStackNameById")
SELECT
  sname
FROM r_tech_stack
WHERE project_id = #para(0)
#end
