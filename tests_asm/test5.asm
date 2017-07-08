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
push sArea14
js
push -3
lfp
add
lw
sop
lfp
lfp
push tRectangle19
js
add
print
halt

tRectangle19:
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

sArea14:
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
