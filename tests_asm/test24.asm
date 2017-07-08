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
push 28
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
push 27
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
push 26
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
push getAB
js
push -2
lfp
add
lw
sop
lfp
lfp
push valueA
js
push -3
lfp
add
lw
sop
lfp
lfp
push valueA
js
add
print
halt

valueA:
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

getAB:
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
