import { ShoppingBag, ShoppingBasket, ShoppingCart } from "lucide-react";
import type React from "react";
import AppAnonymousNav from "~/components/custom/app-anonymous-nav";
import { Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious } from "~/components/ui/carousel";

export function meta() {
  return [
    { title: "New React Router App" },
    { name: "description", content: "Welcome to React Router!" },
  ];
}

export default function Home() {
  return (
    <>
      <Header />

      <div>
        <AppAnonymousNav />
      </div>

      <Content />
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
    <div className="w-full h-full flex items-center justify-center">
      <header className="flex-1 h-full flex justify-center items-center">
        {icon}
      </header>
    </div>
  )
}

function Header() {
  const slideData: SlideProps[] = [
    {
      icon: <ShoppingCart size={180} />,
      title: "Shopping is happy",
      subTitle: ""
    },
    {
      icon: <ShoppingBag size={180} />,
      title: "Nice Day",
      subTitle: ""
    },
    {
      icon: <ShoppingBasket size={180} />,
      title: "Happy day",
      subTitle: ""
    },
  ] 
  return (
    <header className="w-full h-5/6 flex justify-center">
      <Carousel  className="w-4/5 h-full">
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

function Content() {
  return (
    <main></main>
  )
}
