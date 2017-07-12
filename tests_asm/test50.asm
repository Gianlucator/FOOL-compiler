push 0
push 1
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
lhp
sw
push 1
lhp
add
shp
push 2
lhp
sw
push 1
lhp
add
shp
lhp
push -3
lfp
add
lw
sop
lfp
lfp
push get3B1
js
push -4
lfp
add
lw
print
halt

get3C1:
cfp
lra
push 44
srv
sra
pop
sfp
lrv
lra
js

get3B1:
cfp
lra
push -2
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js
halt
