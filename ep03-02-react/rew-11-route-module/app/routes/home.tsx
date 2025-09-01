import { House, ShoppingBag, ShoppingBasket, ShoppingCart } from "lucide-react";
import type React from "react";
import { useEffect, useRef, useState } from "react";
import AppAnonymousNav from "~/components/custom/app-anonymous-nav";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "~/components/ui/carousel";
import { cn } from "~/lib/utils";

export function meta() {
  return [
    { title: "My Shop | Home" },
    { name: "description", content: "Welcome to My Shop!" },
  ];
}

export default function Home() {

  const [stick, setStick] = useState(false)
  const stickDivRef = useRef<HTMLDivElement | null>(null)

  useEffect(() => {
    const handleScroll = () => {
      const stickDiv = stickDivRef.current
      if(stickDiv) {
        const rect = stickDiv.getBoundingClientRect()
        setStick(rect.top <= 0)
      }
    }

    window.addEventListener('scroll', handleScroll)
    return () => window.removeEventListener('scroll', handleScroll)
  }, [])

  return (
    <>
      <Header />

      <div>
        <div ref={stickDivRef} className={cn('sticky top-0', stick ? 'shadow-md' : '')}>
          <AppAnonymousNav />
        </div>

        <main className="h-[1000px] overflow-y-auto">
          <House size={400} />
        </main>
      </div>
    </>
  );
}

type SlideProps = {
  icon: React.ReactNode
  title: string
  subTitle: string
}

function Slide({icon, title, subTitle} : SlideProps) {
  return (
    <div className="w-full h-full flex items-center justify-center text-white">
      <header className="flex-1 h-full flex justify-center items-center">
        {icon}
      </header>

      <section className="flex-1">
        <h1 className="text-5xl mb-4">{title}</h1>
        <h3 className="text-xl">{subTitle}</h3>
      </section>
    </div>
  )
}

function Header() {
  const slideData: SlideProps[] = [
    {
      icon: <ShoppingCart size={180} />,
      title: "Welcome",
      subTitle: "Welcome to My Shop! We're so glad you're here. Let us know if you need any help finding the perfect item!"
    },
    {
      icon: <ShoppingBag size={180} />,
      title: "Nice Day",
      subTitle: "Hello and welcome! Thanks for stopping by My Shop. We've got new items added all the time, so be sure to check back soon. Happy shopping!"
    },
    {
      icon: <ShoppingBasket size={180} />,
      title: "Happy day",
      subTitle: "Hi there! Thanks for visiting My Shop. Have a look around, and don't hesitate to reach out if you have any questions. We're happy to help!"
    },
  ] 
  return (
    <header className="w-full h-5/6 flex justify-center bg-gray-600">
      <Carousel className="w-4/5 stretch-child">
        <CarouselContent className="h-full">
          {slideData.map((item, index) => 
            <CarouselItem key={index} >
              <Slide {...item} />
            </CarouselItem>
          )}
        </CarouselContent>
        <CarouselPrevious />
        <CarouselNext />
      </Carousel>
    </header>
  )
}
