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
push 2
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
push -2
lfp
add
lw
sop
lfp
lfp
push sArea
js
push -3
lfp
add
lw
sop
lfp
lfp
push tRectangle
js
add
print
halt

sArea:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

tRectangle:
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
