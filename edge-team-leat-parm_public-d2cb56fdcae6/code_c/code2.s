	.text
	.syntax unified
	.eabi_attribute	67, "2.09"
	.cpu	cortex-m0
	.eabi_attribute	6, 12
	.eabi_attribute	7, 77
	.eabi_attribute	8, 0
	.eabi_attribute	9, 1
	.eabi_attribute	34, 0
	.eabi_attribute	17, 1
	.eabi_attribute	20, 1
	.eabi_attribute	21, 0
	.eabi_attribute	23, 3
	.eabi_attribute	24, 1
	.eabi_attribute	25, 1
	.eabi_attribute	38, 1
	.eabi_attribute	18, 4
	.eabi_attribute	26, 2
	.eabi_attribute	14, 0
	.file	"code2.c"
	.globl	run
	.p2align	1
	.type	run,%function
	.code	16
	.thumb_func
run:
	.fnstart
	.pad	#96
	sub	sp, #96
	@APP
	sub	sp, #508
	@NO_APP
	@APP
	sub	sp, #452
	@NO_APP
	movs	r0, #0
	str	r0, [sp, #8]
	movs	r0, #1
	str	r0, [sp, #8]
	movs	r0, #3
	str	r0, [sp, #4]
	ldr	r0, [sp, #8]
	ldr	r1, [sp, #4]
	cmp	r0, r1
	ble	.LBB0_2
	b	.LBB0_1
.LBB0_1:
	ldr	r0, [sp, #4]
	adds	r0, r0, #1
	str	r0, [sp, #4]
	b	.LBB0_3
.LBB0_2:
	ldr	r0, [sp, #8]
	adds	r0, r0, #1
	str	r0, [sp, #8]
	b	.LBB0_3
.LBB0_3:
	movs	r0, #8
	str	r0, [sp]
	ldr	r0, [sp]
	lsrs	r1, r0, #31
	adds	r0, r0, r1
	asrs	r0, r0, #1
	str	r0, [sp]
	b	.LBB0_4
.LBB0_4:
	b	.LBB0_5
.LBB0_5:
	b	.LBB0_5
.Lfunc_end0:
	.size	run, .Lfunc_end0-run
	.cantunwind
	.fnend

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",%progbits
	.addrsig
	.eabi_attribute	30, 6
