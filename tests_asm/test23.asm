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
push getB31
js
print
halt

getB31:
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
