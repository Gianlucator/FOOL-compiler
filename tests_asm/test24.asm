push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 3
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
lhp
sw
push 1
lhp
add
shp
push 10
lhp
sw
push 1
lhp
add
shp
push 4
lhp
sw
push 1
lhp
add
shp
push 1
lhp
sw
push 1
lhp
add
shp
lhp
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
push 4
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
push getAB41
js
push -2
lfp
add
lw
sop
lfp
lfp
push valueA51
js
push -3
lfp
add
lw
sop
lfp
lfp
push valueA51
js
add
print
halt

valueA51:
cfp
lra
push -3
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

getAB41:
cfp
lra
push -4
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
