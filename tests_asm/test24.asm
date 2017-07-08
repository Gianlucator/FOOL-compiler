push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 0
lhp
sw
push 1
lhp
add
shp
lhp
push -2
lfp
add
lw
sop
lfp
lfp
push get3B1
js
print
halt

get3B1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js
